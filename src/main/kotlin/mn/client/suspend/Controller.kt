package mn.client.suspend

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.inject.Singleton

@Singleton
@Controller("/")
class Controller(
        private val client: TheClient
) {
    @Get("service")
    fun doService(): List<SomeType> {
        val data = fetchData()
        return data
    }

    private fun fetchData(): List<SomeType> {
        return listOf(
                SomeType(a = "a1", b = "b1"),
                SomeType(a = "a2", b = "b2")
        )
    }

    @Get("test")
    suspend fun doTest(): List<SomeType> {
        val data = client.getData()
        val t = data.map { SomeType(it.b, it.a) }
        return t
    }
}