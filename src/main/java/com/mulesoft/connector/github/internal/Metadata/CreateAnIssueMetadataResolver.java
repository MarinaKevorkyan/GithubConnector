package com.mulesoft.connector.github.internal.Metadata;

import org.mule.metadata.api.model.MetadataType;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.metadata.MetadataContext;
import org.mule.runtime.api.metadata.MetadataResolvingException;
import org.mule.runtime.api.metadata.resolving.InputTypeResolver;

public class CreateAnIssueMetadataResolver implements InputTypeResolver<String> {

    @Override
    public String getResolverName() {
        return InputTypeResolver.super.getResolverName();
    }

    @Override
    public MetadataType getInputMetadata(MetadataContext metadataContext, String s) throws MetadataResolvingException, ConnectionException {

        return null;
    }

    @Override
    public String getCategoryName() {
        return null;
    }
}
