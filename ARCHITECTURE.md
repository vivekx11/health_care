# Health Care App - Architecture Overview

## Architecture Pattern: MVVM (Model-View-ViewModel)

```
┌─────────────────────────────────────────────────────────────┐
│                         VIEW LAYER                          │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐     │
│  │  Dashboard   │  │   Profile    │  │ Appointments │     │
│  │  Fragment    │  │  Fragment    │  │  Fragment    │     │
│  └──────────────┘  └──────────────┘  └──────────────┘     │
│  ┌──────────────┐  ┌──────────────┐                        │
│  │HealthRecords │  │ Medications  │                        │
│  │  Fragment    │  │  Fragment    │                        │
│  └──────────────┘  └──────────────┘                        │
│                                                              │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐     │
│  │ Appointment  │  │HealthRecord  │  │  Medication  │     │
│  │   Adapter    │  │   Adapter    │  │   Adapter    │     │
│  └──────────────┘  └──────────────┘  └──────────────┘     │
└─────────────────────────────────────────────────────────────┘
                            ↕ (observes LiveData)
┌─────────────────────────────────────────────────────────────┐
│                      VIEWMODEL LAYER                        │
│                 ┌──────────────────────┐                    │
│                 │  HealthCareViewModel │                    │
│                 │  - Patient LiveData  │                    │
│                 │  - Appointments LD   │                    │
│                 │  - HealthRecords LD  │                    │
│                 │  - Medications LD    │                    │
│                 └──────────────────────┘                    │
└─────────────────────────────────────────────────────────────┘
                            ↕ (calls repository)
┌─────────────────────────────────────────────────────────────┐
│                     REPOSITORY LAYER                        │
│                ┌───────────────────────┐                    │
│                │ HealthCareRepository  │                    │
│                │  - Insert operations  │                    │
│                │  - Update operations  │                    │
│                │  - Delete operations  │                    │
│                │  - Query operations   │                    │
│                └───────────────────────┘                    │
└─────────────────────────────────────────────────────────────┘
                            ↕ (uses DAOs)
┌─────────────────────────────────────────────────────────────┐
│                        DATA LAYER                           │
│  ┌──────────────────────────────────────────────────────┐  │
│  │           HealthCareDatabase (Room)                  │  │
│  └──────────────────────────────────────────────────────┘  │
│                                                              │
│  ┌────────────┐ ┌────────────┐ ┌────────────┐             │
│  │ PatientDao │ │Appointment │ │HealthRecord│             │
│  │            │ │    Dao     │ │    Dao     │             │
│  └────────────┘ └────────────┘ └────────────┘             │
│  ┌────────────┐ ┌────────────┐                             │
│  │  Medical   │ │ Medication │                             │
│  │HistoryDao  │ │    Dao     │                             │
│  └────────────┘ └────────────┘                             │
│                                                              │
│  ┌────────────┐ ┌────────────┐ ┌────────────┐             │
│  │  Patient   │ │Appointment │ │HealthRecord│             │
│  │   Model    │ │   Model    │ │   Model    │             │
│  └────────────┘ └────────────┘ └────────────┘             │
│  ┌────────────┐ ┌────────────┐                             │
│  │  Medical   │ │ Medication │                             │
│  │  History   │ │   Model    │                             │
│  └────────────┘ └────────────┘                             │
└─────────────────────────────────────────────────────────────┘
```

## Data Flow

### Read Operation (Query)
```
Fragment → ViewModel → Repository → DAO → Database
                ↓
         LiveData Observer
                ↓
         UI Updates Automatically
```

### Write Operation (Insert/Update/Delete)
```
Fragment → ViewModel → Repository → ExecutorService
                                          ↓
                                    DAO → Database
                                          ↓
                                    LiveData Updated
                                          ↓
                                    UI Refreshes
```

## Package Structure

```
com.example.health_care/
├── MainActivity.java
├── HealthCareApplication.java
│
├── data/
│   ├── model/
│   │   ├── Patient.java
│   │   ├── Appointment.java
│   │   ├── HealthRecord.java
│   │   ├── MedicalHistory.java
│   │   └── Medication.java
│   │
│   ├── dao/
│   │   ├── PatientDao.java
│   │   ├── AppointmentDao.java
│   │   ├── HealthRecordDao.java
│   │   ├── MedicalHistoryDao.java
│   │   └── MedicationDao.java
│   │
│   ├── database/
│   │   └── HealthCareDatabase.java
│   │
│   └── repository/
│       └── HealthCareRepository.java
│
├── viewmodel/
│   └── HealthCareViewModel.java
│
├── adapter/
│   ├── AppointmentAdapter.java
│   ├── HealthRecordAdapter.java
│   └── MedicationAdapter.java
│
├── util/
│   ├── PermissionHelper.java
│   ├── DateTimeHelper.java
│   └── MedicationScheduler.java
│
├── worker/
│   └── MedicationReminderWorker.java
│
└── fragments/
    ├── DashboardFragment.java
    ├── ProfileFragment.java
    ├── AppointmentsFragment.java
    ├── HealthRecordsFragment.java
    ├── MedicationsFragment.java
    ├── FirstFragment.java
    └── SecondFragment.java
```

## Key Components

### 1. Database Layer (Room)
- **HealthCareDatabase**: Singleton Room database
- **DAOs**: Interface for database operations
- **Models**: Entity classes with @Entity annotation

### 2. Repository Layer
- **HealthCareRepository**: Single source of truth
- Abstracts data sources
- Handles background threading with ExecutorService

### 3. ViewModel Layer
- **HealthCareViewModel**: Survives configuration changes
- Exposes LiveData to UI
- No direct reference to Views

### 4. View Layer
- **Fragments**: UI components
- **Adapters**: RecyclerView data binding
- Observes LiveData from ViewModel

### 5. Background Tasks
- **WorkManager**: Scheduled tasks
- **MedicationReminderWorker**: Notification worker

## Navigation Flow

```
MainActivity
    ↓
DashboardFragment (Start Destination)
    ├→ ProfileFragment
    ├→ AppointmentsFragment
    ├→ HealthRecordsFragment
    └→ MedicationsFragment
```

## Database Schema

```sql
-- patients table
CREATE TABLE patients (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    dateOfBirth TEXT,
    gender TEXT,
    bloodType TEXT,
    phoneNumber TEXT,
    email TEXT,
    address TEXT,
    emergencyContact TEXT,
    emergencyPhone TEXT,
    profileImagePath TEXT
);

-- appointments table
CREATE TABLE appointments (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    doctorName TEXT,
    specialty TEXT,
    date TEXT,
    time TEXT,
    location TEXT,
    notes TEXT,
    status TEXT
);

-- health_records table
CREATE TABLE health_records (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    type TEXT,
    value TEXT,
    unit TEXT,
    date TEXT,
    time TEXT,
    notes TEXT
);

-- medical_history table
CREATE TABLE medical_history (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    condition TEXT,
    diagnosisDate TEXT,
    status TEXT,
    notes TEXT
);

-- medications table
CREATE TABLE medications (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    dosage TEXT,
    frequency TEXT,
    startDate TEXT,
    endDate TEXT,
    instructions TEXT,
    reminderEnabled INTEGER,
    reminderTime TEXT
);
```

## Threading Model

### Main Thread (UI Thread)
- Fragment lifecycle
- UI updates
- LiveData observation

### Background Thread (ExecutorService)
- Database operations (insert, update, delete)
- Heavy computations
- File I/O

### WorkManager Thread
- Scheduled tasks
- Notification delivery
- Background sync

## Lifecycle Management

```
Activity/Fragment Lifecycle
    ↓
ViewModel (survives config changes)
    ↓
Repository (application scope)
    ↓
Database (singleton, app lifetime)
```

## Security Layers

1. **Permission Layer**: Runtime permissions
2. **Data Layer**: Room database with encryption support
3. **Network Layer**: (Future) HTTPS/TLS
4. **Storage Layer**: AndroidX Security Crypto

## Benefits of This Architecture

1. **Separation of Concerns**: Each layer has specific responsibility
2. **Testability**: Easy to unit test each component
3. **Maintainability**: Clear structure, easy to modify
4. **Scalability**: Easy to add new features
5. **Lifecycle Awareness**: Prevents memory leaks
6. **Reactive UI**: LiveData automatically updates UI
7. **Offline First**: Local database with Room

## Design Patterns Used

- **Singleton**: Database instance
- **Repository**: Data abstraction
- **Observer**: LiveData observation
- **Factory**: ViewModel creation
- **Adapter**: RecyclerView binding
- **Builder**: Room database builder
- **DAO**: Data access abstraction

## Technology Stack Summary

- **Language**: Java 8
- **UI**: Material Design 3
- **Architecture**: MVVM
- **Database**: Room (SQLite)
- **Async**: LiveData + ExecutorService
- **Background**: WorkManager
- **Navigation**: Navigation Component
- **DI**: Manual (can add Hilt/Dagger)
- **Charts**: MPAndroidChart (ready to use)
