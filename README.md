
# react-native-http-cache

## Getting started

`$ npm install react-native-http-cache --save`

### Mostly automatic installation

`$ react-native link react-native-http-cache`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-http-cache` and add `DMNHttpCache.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libDMNHttpCache.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.damoness.rn.DMNHttpCachePackage;` to the imports at the top of the file
  - Add `new DMNHttpCachePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-http-cache'
  	project(':react-native-http-cache').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-http-cache/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-http-cache')
  	```


## Usage
```javascript
import DMNHttpCache from 'react-native-http-cache';

// TODO: What to do with the module?
DMNHttpCache;
```
  