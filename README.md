# GitHubStars
 Brightwheel Take Home Assignment

 |Light Mode|Dark Mode|
 |----------|---------|
 |![Screenshot of GitHub Stars in Light Mode](/imgs/light_mode.jpg)|![Screenshot of GitHub Stars in Dark Mode](/imgs/dark_mode.jpg)|

# Build Information

Android Studio Iguana | 2023.2.1 Patch 1
Build #AI-232.10300.40.2321.11567975, built on March 12, 2024

Kotlin 1.9.23

### Test Device
- Galaxy Fold 5 (Physical)
- Pixel 3a - API 31 (Emulator)

# Features
- Fetch top 100 repositories by stars ✅
- Load top contributor ✅
- Dark mode support ✅
- Jetpack Compose ✅
- MVVM ✅
- Dependency Injection with Hilt ✅
- Unit Tests ❌

# Tradeoffs & Decisions
**Reveal Top Contributor**
This is a tricky but common problem, where we do not have the ability to update
the API to optimize but can be resolved with UI interaction. In order to not
overwhelm the server and allow the user to see what they want when they wanted
I opted into a button to show the top contributor. The API call returns pretty
instantly so I feel this is a decent tradeoff decision.

**No Unit Tests**
The requirements requested around 3 hours of work, so in the interest of time,
tests were not added. The framework is there between the data, domain, and ui
layers that this should be a light lift.

**More Robust GitHubAPIService**
Fetching repos should be more robust. This could be another hour of effort alone
to make the fetch method able to modify the search parameters with a factory,
builder, or arguments to the method. This would be fun to iterate on, but I did
not want to leave this off as the hardcoded top 100. I realize this should be more
robust.

**Image Cache**
Ran out of time, but adding this to Coil would not be a heavy lift. I would add
the imageLoader to the domain DI module, and send the hoisted imageLoader to
the composable's AsyncImage

# Additional Information
There is more I would love to do with this app including:
- Details Screen
- Links to Repo, Owner, and Top Contributor Accounts
- Caching layer with a daily update flag for fresh Information
- Pull to refresh, for forced refresh
- Filtering by the topic based on this top 100

Thank you for the opportunity, this was a fun project with some unique aspects to it.
# Made With Love ❤️
