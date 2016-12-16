package com.huan.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @author <a href="mailto:jean@eastcode.org">Jean Seurin</a>
 * @since 11/09/15 - 15:28
 */
public class AbstractConfiguration implements EnvironmentAware {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected Environment env;
    protected RelaxedPropertyResolver resolver;

    @Override
    public void setEnvironment(Environment env) {
        this.env = env;
        this.resolver = new RelaxedPropertyResolver(env);
    }
}
