/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.sleuth.instrument.async;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(classes = SleuthContextListener.class)
class SleuthContextListenerTest {

	@Autowired
	private ConfigurableApplicationContext applicationContext;

	@Test
	void should_be_usable_using_context() {
		SleuthContextListener listener = SleuthContextListener
				.getBean(applicationContext);

		then(listener).isNotNull();
		then(listener.isUnusable()).isFalse();
	}

	@Test
	void should_be_usable_using_beanfactory() {
		SleuthContextListener listener = SleuthContextListener
				.getBean(applicationContext.getBeanFactory());

		then(listener).isNotNull();
		then(listener.isUnusable()).isFalse();
	}

}
