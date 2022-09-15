package com.mulesoft.connector.github.internal.Metadata;

import com.mulesoft.connector.github.internal.Param.ReposValueProvider;
import org.mule.metadata.api.model.MetadataType;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.metadata.MetadataContext;
import org.mule.runtime.api.metadata.MetadataKey;
import org.mule.runtime.api.metadata.MetadataResolvingException;
import org.mule.runtime.api.metadata.resolving.InputTypeResolver;
import org.mule.runtime.api.metadata.resolving.TypeKeysResolver;

import java.util.HashSet;
import java.util.Set;

public class CreateAnIssueMetadataResolver implements TypeKeysResolver, InputTypeResolver<ReposValueProvider> {

    @Override
    public Set<MetadataKey> getKeys(MetadataContext metadataContext) throws MetadataResolvingException, ConnectionException {
        Set<MetadataKey> setOfKeys = new HashSet<>();

//        for(){
//
//        }


        return null;
    }

    @Override
    public String getResolverName() {
        return InputTypeResolver.super.getResolverName();
    }

    @Override
    public MetadataType getInputMetadata(MetadataContext metadataContext, ReposValueProvider usernameAndRepos) throws MetadataResolvingException, ConnectionException {
        return null;
    }

    @Override
    public String getCategoryName() {
        return null;
    }
}
