/**
 * 
 * Copyright (C) 2014 Seagate Technology.
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */

package com.seagate.kinetic.simulator.io.provider.nio.ssl;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslHandler;

import java.util.logging.Logger;

import javax.net.ssl.SSLEngine;

import com.seagate.kinetic.common.lib.TlsUtil;
import com.seagate.kinetic.common.protocol.codec.KineticDecoder;
import com.seagate.kinetic.common.protocol.codec.KineticEncoder;
import com.seagate.kinetic.simulator.io.provider.nio.NioMessageServiceHandler;
//import com.seagate.kinetic.proto.Kinetic;
import com.seagate.kinetic.simulator.io.provider.spi.MessageService;

public class SslChannelInitializer extends
ChannelInitializer<SocketChannel> {

	private static final Logger logger = Logger
			.getLogger(SslChannelInitializer.class.getName());

	private MessageService lcservice = null;

	public SslChannelInitializer(MessageService lcservice2) {
		this.lcservice = lcservice2;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {

		ChannelPipeline pipeline = ch.pipeline();

		SSLEngine engine = SslContextFactory.getServerContext()
				.createSSLEngine();

		engine.setUseClientMode(false);

		// enable TLS v1.x protocols.
		TlsUtil.enableSupportedProtocols(engine);

		// add ssl handler
		pipeline.addLast("ssl", new SslHandler(engine));

		
			// decoder
			pipeline.addLast("decoder", new KineticDecoder());
			// encoder
			pipeline.addLast("encoder", new KineticEncoder());
		

        // pipeline.addLast("handler", new SslMessageServiceHandler(lcservice));

        pipeline.addLast("handler", new NioMessageServiceHandler(lcservice,
                true));

		logger.info("ssl nio channel initialized ... ");
	}
}
