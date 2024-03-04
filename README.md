# Increment JSON value

This extension adds a session handling rule to Burp that increments the `orderNumber` JSON key value pair by one for each request that it processes.

## Usage
1. Load extension into Burp
2. Register session handling rule (Settings > Sessions > Session handling rules > Add > Add > Invoke a Burp extension)
3. Set scope on session handling rule to appropriate endpoints
4. Confirm all details

## Notes
- If extension is reloaded, counter will reset to 1
- Currently, name to match is hardcoded, as is value prefix
- If `orderNumber` is not present, it will be added
- It is expected that request body has JSON content to replace.

## Build
Run `./gradlew jar` to build project.

## Any issues
Please raise an issue on the repo.