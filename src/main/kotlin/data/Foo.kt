package data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Foo(
    val bar: String,
)
