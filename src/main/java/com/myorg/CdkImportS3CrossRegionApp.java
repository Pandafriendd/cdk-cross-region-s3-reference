package com.myorg;

import software.amazon.awscdk.core.App;

import java.util.Arrays;

public class CdkImportS3CrossRegionApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkImportS3CrossRegionStack(app, "CdkImportS3CrossRegionStack");

        app.synth();
    }
}
