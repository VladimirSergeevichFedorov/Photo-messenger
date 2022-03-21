rootProject.name = "Photoch"

include(":app")
include(":data")
include(":common")
include(":domain")
include(":feature_login")
include(":feature_tape")

include(":data:data-api")
include(":data:data-impl")
include(":feature_login:feature-login-api")
include(":feature_login:feature-login-impl")

include(":feature_tape:feature-tape-api")
include(":feature_tape:feature-tape-impl")
