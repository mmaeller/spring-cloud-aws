/*
 * Copyright 2013-2022 the original author or authors.
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
package io.awspring.cloud.sqs.listener;

import io.awspring.cloud.sqs.listener.sink.MessageSink;
import io.awspring.cloud.sqs.listener.source.MessageSourceFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.messaging.Message;

/**
 * Interface representing a container for a {@link AsyncMessageListener} with {@link SmartLifecycle} capabilities.
 *
 * @param <T> the {@link Message} payload type.
 *
 * @author Tomaz Fernandes
 * @since 3.0
 */
public interface MessageListenerContainer<T> extends SmartLifecycle {

	/**
	 * Get the container id.
	 * @return the id.
	 */
	String getId();

	/**
	 * Set the factory that will be used to create
	 * {@link io.awspring.cloud.sqs.listener.source.MessageSource} instances for this
	 * container.
	 * @param messageSourceFactory the factory instance.
	 */
	void setMessageSourceFactory(MessageSourceFactory<T> messageSourceFactory);

	/**
	 * Set the {@link MessageSink} instance that will be used to emit messages in this
	 * container.
	 * @param messageSink the sink instance.
	 */
	void setMessageSink(MessageSink<T> messageSink);

	/**
	 * Set the listener to be used to receive messages.
	 * @param asyncMessageListener the message listener instance.
	 */
	void setAsyncMessageListener(AsyncMessageListener<T> asyncMessageListener);

}