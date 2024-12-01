plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "kotlin-apps"
include("english")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("springBoot", "3.3.5")
            library("starter-webflux", "org.springframework.boot", "spring-boot-starter-webflux").versionRef("springBoot")
//            library("starter-netty", "org.springframework.boot", "spring-boot-starter-netty").versionRef("springBoot")
            library("starter-mongodb", "org.springframework.boot", "spring-boot-starter-data-mongodb-reactive").versionRef("springBoot")
        }
    }
}