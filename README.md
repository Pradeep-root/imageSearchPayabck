# image Search Pixabay Payabck 

### Implementation
1. **Architecture** : **_MVVM + CLEAN_** : Keeping separate the UI, business logic, and data resources, ViewModel class extends by ViewModel() it is a Jetpack component, also falowed the Repository methedology. 
2. **Libraries and Jetpack component** 
	- **_Retrofit_ (Netowrk Request)** : Retrofit is a REST Client for Java and Android. It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice. In Retrofit you configure which converter is used for the data serialization. Typically for JSON you use GSon.

	- **_Coroutines_(Handling asynchronous calls)**: For asynchronous or non-blocking programming. When creating server-side, mobile applications, it's important to provide an experience that is not only fluid from the user's perspective, but scalable when needed.

	- **_Dagger-Hilt_(Dependency injection)** : For dependency injection.

	- **_LiveData_** : Sharing data anywhere in the class by using observer methedology.

	- **_okhttp3 interceptor_(Caching response)** :  Retrofit uses the OkHttp library for HTTP requests and interceptor is used for response, caching network expetions handling and debugging. 

	- **_Glide_** : Glide is an Image Loader Library for Android developed by bumptech and is a library that is recommended by Google. It has been used in many Google open source projects including Google official application. One of the key features of successful and effective image loading is caching.

	- **_Mockk_** : For testing it is new and easy test envoirnment that reducess lots of boiler code. 

	- **_Truth_** : For asserting the result this is good and easy library provied by Google.

## Needfull Handlings
- Shown loading data event handling during web call.
- Portrait and landscape screen support.
- Web Error handling.
- No Internet connectivity error handling (All type of network connectivity check).
- Proper indication for image loading and error.
