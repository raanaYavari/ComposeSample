# Jetpack Compose Project with Clean Architecture, MVVM, Hilt, Retrofit, and Navigation Component

This is a sample Android project showcasing the implementation of a Jetpack Compose application using Clean Architecture, MVVM design pattern, Hilt for dependency injection, Retrofit for API communication, and the Navigation Component for seamless navigation between screens. The application fetches data from the [JSONPlaceholder](https://jsonplaceholder.typicode.com) API.

## Features

- Utilizes Jetpack Compose for UI development.
- Implements Clean Architecture for separation of concerns.
- Follows MVVM design pattern for better testability and maintainability.
- Uses Hilt for dependency injection, making it easy to manage dependencies.
- Utilizes Retrofit for network communication.
- Utilizes the Navigation Component for navigation between screens.

## Libraries Used

- [Jetpack Compose](https://developer.android.com/jetpack/compose): Modern toolkit for building native Android UIs.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel): Store and manage UI-related data.
- [Coroutines](https://developer.android.com/kotlin/coroutines): Kotlin's way of doing asynchronous programming.
- [Hilt](https://dagger.dev/hilt/): Dependency injection framework.
- [Retrofit](https://square.github.io/retrofit/): Type-safe HTTP client for Android and Java.
- [GSON](https://github.com/google/gson): Library for JSON serialization and deserialization.
- [OkHttp](https://square.github.io/okhttp/): HTTP client that efficiently handles HTTP requests.
- [Navigation Component](https://developer.android.com/guide/navigation): Provides a framework for navigation within your app.

## Architecture

This project follows the Clean Architecture principles, which separates the application into different layers:

1. **Presentation Layer** (UI): This layer contains the Jetpack Compose components, ViewModels, and UI-related logic.

2. **Domain Layer**: This layer contains the business logic of the application. It defines entities, use cases, and repositories.

3. **Data Layer**: This layer is responsible for fetching data from external sources. It includes API interfaces, data sources, and data models.

## Getting Started

1. Clone the repository:

```bash
git clone https://github.com/raanaYavari/ComposeSample.git
```

2. Open the project in Android Studio or your preferred IDE.

3. Build and run the application on an Android emulator or a physical device.

## Usage

1. Upon launching the app, it will fetch data from the JSONPlaceholder API and display it in a list.

2. You can click on individual items to view more details.

3. Use the Navigation Component to navigate between different screens.

## Contributing

If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.

2. Create a new branch for your feature or bug fix:

```bash
git checkout -b feature/your-feature
```

3. Make your changes and commit them:

```bash
git commit -m 'Add a new feature'
```

4. Push the branch to your fork:

```bash
git push origin feature/your-feature
```

5. Create a pull request from your fork to the original repository.
