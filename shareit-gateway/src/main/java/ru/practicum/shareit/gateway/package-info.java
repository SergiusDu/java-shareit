@org.springframework.modulith.ApplicationModule(
    displayName = "API Gateway",
    allowedDependencies = {"shared", "user :: *"}
    )
package ru.practicum.shareit.gateway;