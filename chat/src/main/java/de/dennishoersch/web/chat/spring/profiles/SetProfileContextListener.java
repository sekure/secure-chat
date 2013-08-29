/*
 * Copyright 2012-2013 Dennis Hörsch.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.dennishoersch.web.chat.spring.profiles;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;

/**
 * 
 * @author hoersch
 */
public class SetProfileContextListener implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private final Logger logger = Logger.getLogger(getClass());

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        if (!(applicationContext instanceof ConfigurableWebApplicationContext)) {
            logger.error("ApplicationContext is no WebApplicationContext! (" + applicationContext.getClass() + ")");
            return;
        }

        Profiles.addProfiles((ConfigurableWebApplicationContext) applicationContext);
    }
}
