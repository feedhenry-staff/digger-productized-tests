package com.redhat.rhmap.digger.test;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;
import org.aerogear.digger.test.DiggerTestDataProvider;
import org.aerogear.digger.test.DiggerTestingEnv;

public class ProductizedTemplatesTestModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder
                .bind(DiggerTestDataProvider.class)
                .to(ProductizedTemplatesDataProvider.class)
                .in(Scopes.SINGLETON);

        binder
                .bind(DiggerTestingEnv.class)
                .to(ProductizedTemplatesDiggerTestingEnv.class)
                .in(Scopes.SINGLETON);

    }
}
