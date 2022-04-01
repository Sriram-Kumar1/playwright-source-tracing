package com.automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.util.*;
import org.junit.*;
import java.nio.file.Paths;
public class AppTest {
  @Test 
public void LogintestWithTrace() {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
     /* context.tracing().start(new Tracing.StartOptions()
            .setScreenshots(true)
            .setSnapshots(true)
            .setSources(true));
            */
            context.tracing().start(new Tracing.StartOptions()
            .setScreenshots(true)
            .setSnapshots(true)
            .setSources(true));
     Page page = context.newPage();
    page.navigate("http://www.google.com");
    context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
    }
