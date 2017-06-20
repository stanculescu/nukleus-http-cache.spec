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

public class ProxyIT
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
        "${streams}/proxy.request/accept/client",
        "${streams}/proxy.request/accept/server",
        "${streams}/proxy.request/connect/client",
        "${streams}/proxy.request/connect/server",
        })
    public void shouldProxyRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/debounce.cache.sync/accept/client",
        "${streams}/debounce.cache.sync/accept/server",
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
        "${streams}/not.debounce.multiple.requests/accept/client",
        "${streams}/not.debounce.multiple.requests/accept/server",
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
        "${streams}/not.debounce.private.cache/accept/client",
        "${streams}/not.debounce.private.cache/accept/server",
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
        "${streams}/not.debounce.implied.private/accept/client",
        "${streams}/not.debounce.implied.private/accept/server",
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
        "${streams}/debounce.when.explicitly.public/accept/client",
        "${streams}/debounce.when.explicitly.public/accept/server",
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
        "${streams}/not.debounce.varys/accept/client",
        "${streams}/not.debounce.varys/accept/server",
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
        "${streams}/cache.response/accept/client",
        "${streams}/cache.response/accept/server",
        "${streams}/cache.response/connect/client",
        "${streams}/cache.response/connect/server",
    })
    public void shouldCacheResponse() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.response.and.push.promise/accept/client",
        "${streams}/cache.response.and.push.promise/accept/server",
        "${streams}/cache.response.and.push.promise/connect/client",
        "${streams}/cache.response.and.push.promise/connect/server",
    })
    public void shouldCacheResponseAndPushPromise() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.post.request/accept/client",
        "${streams}/proxy.post.request/accept/server",
        "${streams}/proxy.post.request/connect/client",
        "${streams}/proxy.post.request/connect/server",
    })
    public void shouldProxyPostRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

}
