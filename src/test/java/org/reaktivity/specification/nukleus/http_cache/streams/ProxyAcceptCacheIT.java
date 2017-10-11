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

public class ProxyAcceptCacheIT
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
        "${streams}/proxy.get.request/accept/client",
        "${streams}/proxy.get.request/accept/server",
        })
    public void shouldProxyGetRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.get.request.with.body/accept/client",
        "${streams}/proxy.get.request.with.body/accept/server",
        })
    public void shouldProxyGetRequestWithBody() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.get.request.with.transfer.encoding/accept/client",
        "${streams}/proxy.get.request.with.transfer.encoding/accept/server",
    })
    public void shouldProxyGetRequestWithTransferEncoding() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.post.request/accept/client",
        "${streams}/proxy.post.request/accept/server",
    })
    public void shouldProxyPostRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.request.and.304/accept/client",
        "${streams}/proxy.request.and.304/accept/server",
    })
    public void shouldProxyRequestWith304() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.max-age/accept/client",
        "${streams}/cache.max-age/accept/server",
    })
    public void shouldCacheMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.max-age/accept/client",
        "${streams}/expire.max-age/accept/server",
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
            "${streams}/invalidate.cache/unsafe/post.ok/accept/client",
            "${streams}/invalidate.cache/unsafe/post.ok/accept/server",
    })
    public void shouldInvalidateCachePostOk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/unsafe/post.failed/accept/client",
            "${streams}/invalidate.cache/unsafe/post.failed/accept/server",
    })
    public void shouldInvalidateCachePostFailed() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/unsafe/put.ok/accept/client",
            "${streams}/invalidate.cache/unsafe/put.ok/accept/server",
    })
    public void shouldInvalidateCachePutOk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/unsafe/put.failed/accept/client",
            "${streams}/invalidate.cache/unsafe/put.failed/accept/server",
    })
    public void shouldInvalidateCachePutFailed() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/unsafe/delete.ok/accept/client",
            "${streams}/invalidate.cache/unsafe/delete.ok/accept/server",
    })
    public void shouldInvalidateCacheDeleteOk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/unsafe/delete.failed/accept/client",
            "${streams}/invalidate.cache/unsafe/delete.failed/accept/server",
    })
    public void shouldInvalidateCacheDeleteFailed() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/link/invalidates.success/post.ok/accept/client",
            "${streams}/invalidate.cache/link/invalidates.success/post.ok/accept/server",
    })
    public void shouldLinkInvalidateCachePostOk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/link/invalidates.success/post.failed/accept/client",
            "${streams}/invalidate.cache/link/invalidates.success/post.failed/accept/server",
    })
    public void shouldLinkInvalidateCachePostFailed() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/link/invalidates.success/put.ok/accept/client",
            "${streams}/invalidate.cache/link/invalidates.success/put.ok/accept/server",
    })
    public void shouldLinkInvalidateCachePutOk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/link/invalidates.success/put.failed/accept/client",
            "${streams}/invalidate.cache/link/invalidates.success/put.failed/accept/server",
    })
    public void shouldLinkInvalidateCachePutFailed() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/link/invalidates.success/delete.ok/accept/client",
            "${streams}/invalidate.cache/link/invalidates.success/delete.ok/accept/server",
    })
    public void shouldLinkInvalidateCacheDeleteOk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/invalidate.cache/link/invalidates.success/delete.failed/accept/client",
            "${streams}/invalidate.cache/link/invalidates.success/delete.failed/accept/server",
    })
    public void shouldLinkInvalidateCacheDeleteFailed() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/should.bypass.cache.on.no.cache/accept/client",
        "${streams}/should.bypass.cache.on.no.cache/accept/server",
    })
    public void shouldByPassCacheOnNoCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/cache.get.request.with.no-store/accept/client",
            "${streams}/cache.get.request.with.no-store/accept/server",
    })
    public void shouldCacheGetRequestWithNoStore() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/cache.get.request.with.no-store.and.response.marked.cacheable/accept/client",
            "${streams}/cache.get.request.with.no-store.and.response.marked.cacheable/accept/server",
    })
    public void shouldCacheGetRequestWithNoStoreAndResponeMarkedCacheable() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.s-maxage/accept/client",
        "${streams}/cache.s-maxage/accept/server",
    })
    public void shouldCacheSMaxage() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.s-maxage/accept/client",
        "${streams}/expire.s-maxage/accept/server",
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
        "${streams}/cache.by.default.for.5.seconds/accept/client",
        "${streams}/cache.by.default.for.5.seconds/accept/server",
    })
    public void shouldCacheDefaultCacheableFor5Seconds() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.cache.by.default.for.5.seconds/accept/client",
        "${streams}/expire.cache.by.default.for.5.seconds/accept/server",
    })
    public void shouldExpireCacheDefaultCacheableFor5Seconds() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.by.default.for.10.percent.of.last-modified/accept/client",
        "${streams}/cache.by.default.for.10.percent.of.last-modified/accept/server",
    })
    public void shouldCacheDefaultFor10PercentOfLastModified() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.cache.by.default.for.10.percent.of.last-modified/accept/client",
        "${streams}/expire.cache.by.default.for.10.percent.of.last-modified/accept/server",
    })
    public void shouldExpireCacheDefaultFor10PercentOfLastModified() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/private.cache/accept/client",
        "${streams}/private.cache/accept/server",
    })
    public void shouldNotUsePrivateCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/implied.private.cache/accept/client",
        "${streams}/implied.private.cache/accept/server",
    })
    public void shouldNotUseImpliedPrivateCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/explicitly.public.cache/accept/client",
        "${streams}/explicitly.public.cache/accept/server",
    })
    public void shouldUseExplicitlyPublicCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.use.cache.that.varys/accept/client",
        "${streams}/not.use.cache.that.varys/accept/server",
    })
    public void shouldNotUseCacheForRequestThatVarys() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.that.varys.but.matches/accept/client",
        "${streams}/cache.that.varys.but.matches/accept/server",
    })
    public void shouldUseCacheForRequestThatMatchesVarys() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.response.too.large.to.cache/accept/client",
        "${streams}/proxy.response.too.large.to.cache/accept/server",
    })
    public void shouldProxyResponseTooLargeToCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    // TODO 304 on etags or last-modified
}
