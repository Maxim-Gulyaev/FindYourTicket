pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FindYourTicket"
include(":app")
include(":core")
include(":air_ticket")
include(":air_ticket:feature_air_ticket_data")
include(":air_ticket:feature_air_ticket_domain")
include(":air_ticket:feature_air_ticket_presentation")
include(":core:base")
include(":core:utils")
