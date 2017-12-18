# ColorBox library

[ ![Download](https://api.bintray.com/packages/enricod/colorbox/cbl/images/download.svg?version=1.0.3) ](https://bintray.com/enricod/colorbox/cbl/1.0.3/link)

[![Android Arsenal](androidarsenalhere)


### Features

- Dynamic color preview;
- Change color **A**lpha **R**ed **G**reen and **B**lue sliders;
- Clearable recent colors;
- Material palettes (>200 colors!);
- ColorBox preference;
- Easy to implement;



![ScreenShot](https://github.com/enricocid/ColorBox-library/blob/master/files/art.png)
------

# Sample Project

*You can download the latest sample APK from this repo here:* https://github.com/enricocid/ColorBox-library/blob/master/files/release/app-release.apk


# Standalone app

*If You want to try the ColorBox here is also a standalone version of the homonym library. It has the same features, in addition You can apply colors as solid wallpapers or copy the hex color code to clipboard :D*
 
<a href="https://play.google.com/store/apps/details?id=com.github.colorbox" target="_blank">
  <img alt="Get it on Google Play"
       src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" height="60"/>
</a>



# Gradle Dependency

### Repository

*The Gradle dependency is available via [jCenter](https://bintray.com/enricod/Enrico/ColorBox-library/view).
jCenter is the default Maven repository used by Android Studio.*

*The minimum API level supported by this library is API 21 (Lollipop).*

### Download

- If You are using gradle:3.0+ You should use '*implementation*' configuration. Add the following dependency to your project's build.gradle:

```gradle
dependencies {
    // ... other dependencies here
    implementation 'com.github.enricocid:cbl:1.0.3'
}
```

- For gradle versions < 3.0 use 'compile' configuration:

```gradle
dependencies {
    // ... other dependencies here
    compile 'com.github.enricocid:cbl:1.0.3'
}
```




# Usage

### To display the color box simply:

```java
ColorBox.showColorBox(String tag, Activity activity);
```


**tag:** it's a string used to identify the ColorBox.

# Usage instructions for Preferences

![ScreenShot](https://github.com/enricocid/ColorBox-library/blob/master/files/preferences.png)

*In Your preferences XML add:*

```xml
<com.github.colorbox.ColorBoxPreference android:key="the_key_want" android:title="@string/your_string"/>
```

**note:** don't forget to add a (different) key and a title for every ColorBoxPreference You add in Your preferences XML.

*In You Preference fragment (onResume) add this*

```java
@Override
    public void onResume() {
        super.onResume();

        ColorBox.registerPreferenceUpdater(Activity activity);
    }
```

# To retrieve the color:

```java
int color = ColorBox.getColor(String tag, Context context);
```





# Utilities:

### ColorBox.getComplementaryColor(int colorToInvert)

*Returns inverted color:*

![ScreenShot](https://github.com/enricocid/ColorBox-library/blob/master/files/inverted.png)





### ColorBox.getHexadecimal(int color)

*Returns the hexadecimal code from color.*





### ColorBox.isColorDark(int color)

*Determine if the color is dark or light.*




# THAT'S ALL FOLKS!



