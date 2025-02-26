# ReusableComposables
Composable functions for creating generic and customizable app elements

## Features ##

- ** Generic Components **: Build app elements that can be reused across different projects
- ** Customizable **: Tailor the components to fit your specific needs
- ** Ease of Use **: Simply copy and paste the code into your project

## Usage Example ##

```kotlin
fun TopBar_Logo_Icon(
    iconsSize: Int = 40,
    logoSize: Int = 60,
    paddingValues: Int = 0,
    iconTint: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    iconSide: IconSide = IconSide.Left,

    // Consider renaming these parameters to be more descriptive and context-specific
    logo: Painter,
    icon: ImageVector = Icons.Default.Menu,

    // Consider renaming these parameters to be more descriptive and context-specific
    // No use by default
    onButtonClick: () -> Unit = {},

    // Suggestion: Use the text as a <navigation -> toHome> button
    // No use by default
    onLogoClick: () -> Unit = {}

)


Just copy the .kt file in your project and call it from anywhere. The majority of the parameters are default

## Acknowledgments ##
Thanks to everyone who has contributed to this project!
Special thanks to all the users who provide feedback and help improve the project.
