package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.core.CfnOutput;
import software.amazon.awscdk.core.CfnOutputProps;

import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketAttributes;
import software.amazon.awscdk.services.s3.IBucket;

public class CdkImportS3CrossRegionStack extends Stack {
    public CdkImportS3CrossRegionStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public CdkImportS3CrossRegionStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // The code that defines your stack goes here
        
        final IBucket crossRegionImportBucket = Bucket.fromBucketAttributes(this, "CrossRegionImport", BucketAttributes.builder()
                .bucketArn("arn:aws:s3:::asdasdadasdfsjf3")
                .region("us-west-2")
                .build());
        
        new CfnOutput(this, "CrossRegionImportBucketDomain", CfnOutputProps.builder()
                .value(crossRegionImportBucket.getBucketRegionalDomainName())
                .description("Cross Region Import Bucket Domain")
                .build());
    }
}
