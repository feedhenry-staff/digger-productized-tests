package com.redhat.rhmap.digger.test;

import org.aerogear.digger.test.DiggerTestDataProvider;
import org.aerogear.digger.test.Template;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

public class ProductizedTemplatesDataProvider implements DiggerTestDataProvider {

    private Object[][] androidTemplates;
    private Object[][] iosTemplates;
    private Object[][] cordovaTemplates;

    @Override
    public void initialize() {
        // TODO: this is just an example!
        androidTemplates = new Object[][]{
                {new Template("sync_android_app", "Sync Android App", "git://github.com/feedhenry-templates/sync-android-app.git", "master", "client_native_android")}, // temporary
                {new Template("saml_android", "SAML Android", "git://github.com/feedhenry-templates/saml-android-app.git", "master", "client_native_android")} // temporary
        };
        iosTemplates = new Object[][]{
                {new Template("sync_ios_objectivec_app", "Sync iOS (Objective-C) App", "git://github.com/feedhenry-templates/sync-ios-app.git", "master", "client_native_ios")} // temporary
        };
        cordovaTemplates = new Object[][]{
                {new Template("sync_app", "Sync App", "git://github.com/feedhenry-templates/sync-cordova-app.git", "master", "client_advanced_hybrid")} // temporary
        };
    }

    @Override
    @DataProvider(name = "androidTemplates")
    public Object[][] provideAndroidTemplates(ITestContext context) {
        return filterSmokeTemplates(context, androidTemplates);
    }

    @Override
    @DataProvider(name = "iosTemplates")
    public Object[][] provideIosTemplates(ITestContext context) {
        return filterSmokeTemplates(context, iosTemplates);
    }

    @Override
    @DataProvider(name = "cordovaTemplates")
    public Object[][] provideCordovaTemplates(ITestContext context) {
        return filterSmokeTemplates(context, cordovaTemplates);
    }

    // TODO: review this one
    private Object[][] filterSmokeTemplates(ITestContext context, Object[][] templates) {
        List<String> includedGroups = Arrays.asList(context.getIncludedGroups());

        if (includedGroups.contains("smoke")) {
            System.out.println("Only testing templates from 'smoke' list.");
            // TODO return only templates which ids are contained in "smoke templates list"
        }

        return templates;
    }
}

