# Quick Start Guide - Health Care App

## Build & Run

### Option 1: Android Studio
1. Open Android Studio
2. Click "Open" and select this project folder
3. Wait for Gradle sync to complete
4. Click the "Run" button (green play icon)
5. Select your device/emulator

### Option 2: Command Line
```bash
# Build the app
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug

# Or build and install in one command
./gradlew build installDebug
```

## First Time Setup

### 1. Grant Permissions
When the app launches, it will request notification permissions. Click "Allow" to enable medication reminders.

### 2. Create Your Profile
- Tap the "Profile" card on the dashboard
- Fill in your personal information
- Add emergency contact details
- Tap "Save"

### 3. Add Your First Appointment
- Go back to dashboard
- Tap "Appointments"
- Tap the floating action button (+ icon)
- Enter appointment details
- Save

### 4. Track Health Metrics
- From dashboard, tap "Health Records"
- Tap the + button
- Select metric type (blood pressure, glucose, etc.)
- Enter value and notes
- Save

### 5. Add Medications
- From dashboard, tap "Medications"
- Tap the + button
- Enter medication details
- Enable reminder if needed
- Set reminder time
- Save

## Features Overview

### Dashboard
- Central hub for all features
- Quick access cards
- Welcome message with your name

### Profile
- Personal information
- Medical details (blood type)
- Emergency contacts
- Editable at any time

### Appointments
- List of all appointments
- Status tracking (scheduled/completed/cancelled)
- Doctor information
- Date, time, and location

### Health Records
- Track multiple health metrics
- Historical data view
- Add notes to each record
- Date/time stamped

### Medications
- Current medication list
- Dosage and frequency
- Instructions
- Automatic reminders

## Troubleshooting

### Build Errors
```bash
# Clean and rebuild
./gradlew clean build

# Clear Gradle cache
./gradlew --stop
rm -rf ~/.gradle/caches/
./gradlew build
```

### Permission Issues
- Go to Android Settings > Apps > Health Care > Permissions
- Enable required permissions manually

### Database Issues
- Clear app data: Settings > Apps > Health Care > Storage > Clear Data
- This will reset all data (use for testing only)

## Testing the App

### Test Data
You can add sample data to test all features:

1. **Profile**: John Doe, DOB: 1990-01-01, Blood Type: O+
2. **Appointment**: Dr. Smith, Cardiology, Tomorrow 10:00 AM
3. **Health Record**: Blood Pressure, 120/80 mmHg
4. **Medication**: Aspirin, 100mg, Once daily

### Notification Testing
1. Add a medication with reminder enabled
2. Set reminder time to 1-2 minutes from now
3. Wait for notification to appear
4. Check notification drawer

## Development Tips

### Enable Developer Options
1. Go to Settings > About Phone
2. Tap "Build Number" 7 times
3. Go back to Settings > Developer Options
4. Enable "USB Debugging"

### View Database
Use Android Studio's Database Inspector:
1. Run the app
2. View > Tool Windows > App Inspection
3. Select "Database Inspector" tab
4. Explore tables and data

### Debug Logs
Add logs in code:
```java
import android.util.Log;
Log.d("HealthCare", "Your message here");
```

View logs:
```bash
adb logcat | grep HealthCare
```

## Common Issues

### Issue: App crashes on launch
**Solution**: Check if all dependencies are synced. Run `./gradlew clean build`

### Issue: Notifications not showing
**Solution**: 
- Check notification permission is granted
- Verify reminder time is set correctly
- Check Do Not Disturb is off

### Issue: Database not saving data
**Solution**: 
- Check Room database is initialized
- Verify DAO operations are on background thread
- Check for any exceptions in logcat

## Support

For issues or questions:
1. Check PROJECT_SUMMARY.md for implementation details
2. Review README.md for architecture overview
3. Check logcat for error messages
4. Verify all dependencies are properly synced

## Next Steps

After basic setup:
1. Customize the UI colors and themes
2. Add more health metric types
3. Implement data export features
4. Add charts for health trends
5. Integrate with backend API (optional)

Happy coding! 🏥📱
