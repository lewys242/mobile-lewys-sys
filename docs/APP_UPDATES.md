# Mobile Lewys App Updates

The app checks the latest GitHub release in `lewys242/mobile-lewys-sys` for the `mobile-lewys-update.json` asset. Debug builds intentionally disable in-app update checks because they are signed with a local debug key.

## Release manifest

Attach `mobile-lewys-update.json` to every app release. Its `versionCode` must be greater than the installed app's version. Include a URL and SHA-256 digest for every APK variant being published:

```json
{
  "versionCode": 6,
  "versionName": "1.0.5",
  "notes": "Release notes",
  "artifacts": {
    "online": {
      "url": "https://github.com/lewys242/mobile-lewys-sys/releases/download/v1.0.5/mobile-lewys-online.apk",
      "sha256": "<sha256 of the online APK>",
      "sizeBytes": 0
    },
    "offline": {
      "url": "https://github.com/lewys242/mobile-lewys-sys/releases/download/v1.0.5/mobile-lewys-offline.apk",
      "sha256": "<sha256 of the offline APK>",
      "sizeBytes": 0
    }
  }
}
```

## Signing requirement

Every APK offered as an in-app update must have the same Android application ID and be signed with the same private upload key as the installed APK. Configure the `MH_UPLOAD_STORE_FILE`, `MH_UPLOAD_STORE_PASSWORD`, `MH_UPLOAD_KEY_ALIAS`, and `MH_UPLOAD_KEY_PASSWORD` environment variables for release builds. Never commit the keystore or its passwords. A debug APK cannot be updated in place by a release signed with a different key; uninstalling it first removes its app data.
