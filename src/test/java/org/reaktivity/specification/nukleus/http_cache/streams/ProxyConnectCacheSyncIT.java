/**
 * Copyright 2016-2017 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.specification.nukleus.http_cache.streams;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;
import org.reaktivity.specification.nukleus.NukleusRule;

public class ProxyConnectCacheSyncIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("streams", "org/reaktivity/specification/nukleus/http_cache/streams/proxy");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    private final NukleusRule nukleus = new NukleusRule()
            .directory("target/nukleus-itests");

    @Rule
    public final TestRule chain = outerRule(nukleus).around(k3po).around(timeout);

    @Test
    @Specification({
        "${streams}/cache.response.and.push.promise/connect/client",
        "${streams}/cache.response.and.push.promise/connect/server",
    })
    public void shouldUseCachedResponseAndSendPushPromise() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/inject.push.promise/connect/client",
        "${streams}/inject.push.promise/connect/server",
    })
    public void shouldInjectPushPromise() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/inject.header.values/connect/client",
        "${streams}/inject.header.values/connect/server",
    })
    public void shouldInjectHeaderValues() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/inject.missing.header.values/connect/client",
        "${streams}/inject.missing.header.values/connect/server",
    })
    public void shouldInjectMissingHeaderValues() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/debounce.cache.sync/connect/client",
        "${streams}/debounce.cache.sync/connect/server",
    })
    public void shouldDebounceCacheSync() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.request.and.follow.304/connect/client",
        "${streams}/proxy.request.and.follow.304/connect/server",
    })
    public void shouldProxyRequestAndFollow304() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.forward.response.to.push.promise.if.unchanged/connect/client",
        "${streams}/not.forward.response.to.push.promise.if.unchanged/connect/server",
    })
    public void shouldNotForwardResponseToPushPromiseIfUnchanged() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/debounce.cache.sync.and.inject.individualized.push.promise/connect/client",
        "${streams}/debounce.cache.sync.and.inject.individualized.push.promise/connect/server",
    })
    public void shouldDebounceCacheSyncAndInjectIndividualizedPushPromise() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/debounce.cache.sync.but.not.forward.304.without.pp/connect/client",
        "${streams}/debounce.cache.sync.but.not.forward.304.without.pp/connect/server",
    })
    public void shouldDebounceCacheSyncButNotForward304WithoutPP() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.debounce.multiple.requests/connect/client",
        "${streams}/not.debounce.multiple.requests/connect/server",
    })
    public void shouldNotDebounceMultipleRequests() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.debounce.private.cache/connect/client",
        "${streams}/not.debounce.private.cache/connect/server",
    })
    public void shouldNotDebounceWhenCacheSyncPrivateCacheControl() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.debounce.implied.private/connect/client",
        "${streams}/not.debounce.implied.private/connect/server",
    })
    public void shouldNotDebounceWhenImpliedCacheSyncPrivate() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/debounce.when.explicitly.public/connect/client",
        "${streams}/debounce.when.explicitly.public/connect/server",
    })
    public void shouldDebounceExplicitlyPublic() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.debounce.varys/connect/client",
        "${streams}/not.debounce.varys/connect/server",
    })
    public void shouldNotDebounceWhenVarys() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/strip.injected.headers/connect/client",
        "${streams}/strip.injected.headers/connect/server",
    })
    public void shouldStripInjectedHeaders() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/strip.injected.header.values/connect/client",
        "${streams}/strip.injected.header.values/connect/server",
    })
    public void shouldStripInjectedHeaderValues() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/strip.missing.injected.header.values/connect/client",
        "${streams}/strip.missing.injected.header.values/connect/server",
    })
    public void shouldStripMissingInjectedHeaderValues() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

}
