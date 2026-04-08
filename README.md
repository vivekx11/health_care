# Health Care Android App

A comprehensive healthcare management Android application built with Java and Android SDK.

## Features

### 1. Patient Profile Management
- Store personal information (name, DOB, gender, blood type)
- Contact details (phone, email, address)
- Emergency contact information
- Profile photo support

### 2. Appointment Scheduling
- Schedule appointments with doctors
- Track appointment status (scheduled, completed, cancelled)
- View appointment history
- Store doctor information and specialty

### 3. Health Records Tracking
- Track various health metrics:
  - Blood Pressure
  - Blood Glucose
  - Weight
  - Temperature
  - Heart Rate
- View historical data
- Add notes to records

### 4. Medical History
- Record medical conditions
- Track diagnosis dates
- Monitor condition status (active/resolved)
- Add detailed notes

### 5. Medication Management
- Track current medications
- Set medication reminders
- Record dosage and frequency
- View medication instructions
- Automatic notifications for medication times

## Technical Stack

- **Language**: Java
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)
- **Architecture**: MVVM (Model-View-ViewModel)
- **Database**: Room (SQLite)
- **UI**: Material Design 3
- **Navigation**: Android Navigation Component
- **Background Tasks**: WorkManager
- **Charts**: MPAndroidChart

## Dependencies

- AndroidX AppCompat
- Material Components
- Room Database
- Lifecycle Components (ViewModel, LiveData)
- Navigation Component
- WorkManager
- MPAndroidChart
- Security Crypto

## Permissions

- `POST_NOTIFICATIONS` - For medication reminders
- `CAMERA` - For profile photos
- `READ_MEDIA_IMAGES` - For accessing gallery images

## Project Structure

```
app/src/main/java/com/example/health_care/
├── data/
│   ├── model/          # Data models (Patient, Appointment, etc.)
│   ├── dao/            # Room DAOs
│   ├── database/       # Database configuration
│   └── repository/     # Repository pattern implementation
├── viewmodel/          # ViewModels
├── adapter/            # RecyclerView adapters
├── util/               # Utility classes
├── worker/             # WorkManager workers
└── fragments/          # UI fragments

app/src/main/res/
├── layout/             # XML layouts
├── navigation/         # Navigation graph
└── values/             # Strings, colors, themes
```

## Database Schema

### Tables
1. **patients** - Patient profile information
2. **appointments** - Medical appointments
3. **health_records** - Health metrics tracking
4. **medical_history** - Medical conditions
5. **medications** - Medication tracking

## Getting Started

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle dependencies
4. Run on emulator or physical device (API 24+)

## Building the App

```bash
./gradlew assembleDebug
```

## Features to Implement (Future)

- Backend API integration
- Cloud data sync
- Doctor search and booking
- Telemedicine support
- Health reports generation
- Data export (PDF)
- Biometric authentication
- Multi-language support

## Security

- Local data encryption using AndroidX Security Crypto
- Secure storage for sensitive health information
- Permission-based access control

## License

This project is for educational purposes.
