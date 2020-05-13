package mn.client.suspend

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

interface TheClient {
    suspend fun getData(): List<SomeType>
}

@Client("service")
interface GeneratedClient: TheClient {
    @Get("/service")
    override suspend fun getData(): List<SomeType>
}
