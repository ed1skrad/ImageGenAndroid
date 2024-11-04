import com.item.gen.data.ImageData
import retrofit2.http.GET

interface ApiService {
    @GET("item/random")
    suspend fun getImageData(): ImageData
}

