# ICCTA

The results here are prepared using the [Configuration free usage guideline](https://github.com/lilicoding/soot-infoflow-android-iccta/wiki/Configuration%E2%80%93free-usage-of-IccTA).

The only changes we made were to include android-26 jar file from Sdk in the launch script. Furthermore, we set the pathalgo as source only to check if the source and sink matched. 

Therefore, the changed lines were: 

```bash
java -jar iccta.jar $APP_BASENAME $ANDROID_JAR -pathalgo sourceonly &> $PATH_LOGS/$APP_BASENAME-iccta.txt
```
