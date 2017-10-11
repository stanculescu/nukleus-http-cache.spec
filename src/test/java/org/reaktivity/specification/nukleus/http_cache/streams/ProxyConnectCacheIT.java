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

public class ProxyConnectCacheIT
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
        "${streams}/proxy.get.request/connect/client",
        "${streams}/proxy.get.request/connect/server",
        })
    public void shouldProxyGetRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.get.request.with.body/connect/client",
        "${streams}/proxy.get.request.with.body/connect/server",
        })
    public void shouldProxyGetRequestWithBody() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.get.request.with.transfer.encoding/connect/client",
        "${streams}/proxy.get.request.with.transfer.encoding/connect/server",
    })
    public void shouldProxyGetRequestWithTransferEncoding() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.post.request/connect/client",
        "${streams}/proxy.post.request/connect/server",
    })
    public void shouldProxyPostRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.request.and.304/connect/client",
        "${streams}/proxy.request.and.304/connect/server",
    })
    public void shouldProxyRequestWith304() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.max-age/connect/client",
        "${streams}/cache.max-age/connect/server",
    })
    public void shouldCacheMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.max-age/connect/client",
        "${streams}/expire.max-age/connect/server",
    })
    public void shouldExpireMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/request.cache.max-age=0/accept/client",
            "${streams}/request.cache.max-age=0/accept/server",
    })
    public void shouldRequestCacheMaxAgeZero() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/request.cache.max-age=0.and.304/accept/client",
            "${streams}/request.cache.max-age=0.and.304/accept/server",
    })
    public void shouldRequestCacheMaxAgeZeroAnd304() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/unsafe/post.ok/connect/client",
            "${streams}/invalidate.cache/unsafe/post.ok/connect/server",
    })
    public void shouldInvalidateCachePostOk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/unsafe/post.failed/connect/client",
            "${streams}/invalidate.cache/unsafe/post.failed/connect/server",
    })
    public void shouldInvalidateCachePostFailed() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/unsafe/put.ok/connect/client",
            "${streams}/invalidate.cache/unsafe/put.ok/connect/server",
    })
    public void shouldInvalidateCachePutOk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/unsafe/put.failed/connect/client",
            "${streams}/invalidate.cache/unsafe/put.failed/connect/server",
    })
    public void shouldInvalidateCachePutFailed() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/unsafe/delete.ok/connect/client",
            "${streams}/invalidate.cache/unsafe/delete.ok/connect/server",
    })
    public void shouldInvalidateCacheDeleteOk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/unsafe/delete.failed/connect/client",
            "${streams}/invalidate.cache/unsafe/delete.failed/connect/server",
    })
    public void shouldInvalidateCacheDeleteFailed() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/link/invalidates.success/post.ok/connect/client",
            "${streams}/invalidate.cache/link/invalidates.success/post.ok/connect/server",
    })
    public void shouldLinkInvalidateCachePostOk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/link/invalidates.success/post.failed/connect/client",
            "${streams}/invalidate.cache/link/invalidates.success/post.failed/connect/server",
    })
    public void shouldLinkInvalidateCachePostFailed() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/link/invalidates.success/put.ok/connect/client",
            "${streams}/invalidate.cache/link/invalidates.success/put.ok/connect/server",
    })
    public void shouldLinkInvalidateCachePutOk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/link/invalidates.success/put.failed/connect/client",
            "${streams}/invalidate.cache/link/invalidates.success/put.failed/connect/server",
    })
    public void shouldLinkInvalidateCachePutFailed() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/link/invalidates.success/delete.ok/connect/client",
            "${streams}/invalidate.cache/link/invalidates.success/delete.ok/connect/server",
    })
    public void shouldLinkInvalidateCacheDeleteOk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/link/invalidates.success/delete.failed/connect/client",
            "${streams}/invalidate.cache/link/invalidates.success/delete.failed/connect/server",
    })
    public void shouldLinkInvalidateCacheDeleteFailed() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/should.bypass.cache.on.no.cache/connect/client",
        "${streams}/should.bypass.cache.on.no.cache/connect/server",
    })
    public void shouldBypassCacheOnNoCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.s-maxage/connect/client",
        "${streams}/cache.s-maxage/connect/server",
    })
    public void shouldCacheSMaxage() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/cache.get.request.with.no-store/connect/client",
            "${streams}/cache.get.request.with.no-store/connect/server",
    })
    public void shouldCacheGetRequestWithNoStore() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/cache.get.request.with.no-store.and.response.marked.cacheable/connect/client",
            "${streams}/cache.get.request.with.no-store.and.response.marked.cacheable/connect/server",
    })
    public void shouldCacheGetRequestWithNoStoreAndResponeMarkedCacheable() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.s-maxage/connect/client",
        "${streams}/expire.s-maxage/connect/server",
    })
    public void shouldExpireSMaxage() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    // TODO expires headers
    // TODO quoted maxage header
    // TODO quoted smaxage header


    @Test
    @Specification({
        "${streams}/cache.by.default.for.5.seconds/connect/client",
        "${streams}/cache.by.default.for.5.seconds/connect/server",
    })
    public void shouldCacheDefaultCacheableFor5Seconds() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.cache.by.default.for.5.seconds/connect/client",
        "${streams}/expire.cache.by.default.for.5.seconds/connect/server",
    })
    public void shouldExpireCacheDefaultCacheableFor5Seconds() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.by.default.for.10.percent.of.last-modified/connect/client",
        "${streams}/cache.by.default.for.10.percent.of.last-modified/connect/server",
    })
    public void shouldCacheDefaultFor10PercentOfLastModified() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.cache.by.default.for.10.percent.of.last-modified/connect/client",
        "${streams}/expire.cache.by.default.for.10.percent.of.last-modified/connect/server",
    })
    public void shouldExpireCacheDefaultFor10PercentOfLastModified() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/private.cache/connect/client",
        "${streams}/private.cache/connect/server",
    })
    public void shouldNotUsePrivateCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/implied.private.cache/connect/client",
        "${streams}/implied.private.cache/connect/server",
    })
    public void shouldNotUseImpliedPrivateCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/explicitly.public.cache/connect/client",
        "${streams}/explicitly.public.cache/connect/server",
    })
    public void shouldUseExplicitlyPublicCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.use.cache.that.varys/connect/client",
        "${streams}/not.use.cache.that.varys/connect/server",
    })
    public void shouldNotUseCacheForRequestThatVarys() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.that.varys.but.matches/connect/client",
        "${streams}/cache.that.varys.but.matches/connect/server",
    })
    public void shouldUseCacheForRequestThatMatchesVarys() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.response.too.large.to.cache/connect/client",
        "${streams}/proxy.response.too.large.to.cache/connect/server",
    })
    public void shouldProxyResponseTooLargeToCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }
}
