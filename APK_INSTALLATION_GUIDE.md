# Health Care App - APK Installation Guide

## 📱 APK Details

- **File Name**: app-debug.apk
- **Size**: ~7.7 MB
- **Location**: `app/build/outputs/apk/debug/app-debug.apk`
- **Build Type**: Debug
- **Min Android Version**: Android 7.0 (API 24)
- **Target Android Version**: Android 14 (API 34)

## 🚀 Installation Steps

### Method 1: Direct Installation on Phone

1. **Copy APK to Phone**
   - Connect your phone to computer via USB
   - Copy `app-debug.apk` from `app/build/outputs/apk/debug/` folder
   - Paste it to your phone's Downloads folder

2. **Enable Unknown Sources**
   - Go to Settings > Security
   - Enable "Install from Unknown Sources" or "Install Unknown Apps"
   - Allow your File Manager to install apps

3. **Install APK**
   - Open File Manager on your phone
   - Navigate to Downloads folder
   - Tap on `app-debug.apk`
   - Click "Install"
   - Wait for installation to complete
   - Click "Open" to launch the app

### Method 2: Using ADB (Android Debug Bridge)

1. **Enable USB Debugging on Phone**
   - Go to Settings > About Phone
   - Tap "Build Number" 7 times to enable Developer Options
   - Go to Settings > Developer Options
   - Enable "USB Debugging"

2. **Connect Phone to Computer**
   - Connect via USB cable
   - Allow USB debugging when prompted on phone

3. **Install via ADB**
   ```bash
   # Check if device is connected
   adb devices
   
   # Install APK
   adb install app/build/outputs/apk/debug/app-debug.apk
   
   # Or if already installed, reinstall
   adb install -r app/build/outputs/apk/debug/app-debug.apk
   ```

### Method 3: Using Android Studio

1. Open Android Studio
2. Connect your phone via USB
3. Click the "Run" button (green play icon)
4. Select your device from the list
5. App will be installed and launched automatically

## 📋 First Launch Checklist

After installing the app:

1. ✅ Grant notification permission (for medication reminders)
2. ✅ Create your profile (tap Profile card)
3. ✅ Add your first appointment
4. ✅ Track health metrics
5. ✅ Add medications with reminders

## 🔧 Troubleshooting

### Issue: "App not installed"
**Solution**: 
- Make sure you have enough storage space
- Uninstall any previous version first
- Check if Android version is 7.0 or higher

### Issue: "Installation blocked"
**Solution**:
- Enable "Install from Unknown Sources" in Settings
- Allow your File Manager to install apps

### Issue: "App keeps crashing"
**Solution**:
- Clear app data: Settings > Apps > Health Care > Storage > Clear Data
- Reinstall the app
- Make sure Android version is compatible

### Issue: Notifications not working
**Solution**:
- Go to Settings > Apps > Health Care > Notifications
- Enable all notification permissions
- Turn off "Do Not Disturb" mode

## 📍 APK File Location

Full path on your computer:
```
C:\Users\Vivek\AndroidStudioProjects\health_care\app\build\outputs\apk\debug\app-debug.apk
```

## 🔐 Security Note

This is a DEBUG APK meant for testing purposes. For production use:
1. Build a release APK with signing
2. Enable ProGuard/R8 for code obfuscation
3. Remove debug logging

## 📱 System Requirements

- **Minimum**: Android 7.0 (Nougat, API 24)
- **Recommended**: Android 10 or higher
- **Storage**: At least 50 MB free space
- **RAM**: 2 GB or more

## 🎯 Next Steps

After installation:
1. Open the app
2. Follow the on-screen setup
3. Grant necessary permissions
4. Start managing your health data!

## 📞 Support

If you face any issues:
1. Check the QUICK_START.md guide
2. Review the README.md for features
3. Check logcat for error messages:
   ```bash
   adb logcat | grep HealthCare
   ```

---

**Happy Health Tracking! 🏥💊📊**
