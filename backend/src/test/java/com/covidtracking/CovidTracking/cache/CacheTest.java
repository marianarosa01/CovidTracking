package com.covidtracking.CovidTracking.cache;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.covidtracking.CovidTracking.models.Place;
import com.covidtracking.CovidTracking.models.Statistics;

public class CacheTest { //unit testing
    @Test
    public void testMapAssert() throws InterruptedException {
        Cache.cacheMap.clear(); // cleaning cache
        HashMap<String, Object> expectedCashMap = new HashMap<>();

        // Places

        Place france = new Place("France", "fra", "Europe", 65533058);
        Place brasil = new Place("Brazil", "bra", "South America", 215274575);
        Place croatia = new Place("Croatia", "hrv", "Europe", 4059781);
        Place azores = new Place("az", "Azores", "Europe", 4059781);

        Cache.cacheMap.put("country_name_brazil_return_place", brasil);
        Cache.cacheMap.put("country_name_croatia_return_place", croatia);
        Cache.cacheMap.put("country_name_france_return_place", france);

        expectedCashMap.put("country_name_brazil_return_place", brasil);
        expectedCashMap.put("country_name_croatia_return_place", croatia);
        expectedCashMap.put("country_name_france_return_place", france);

        // Statistics

        Statistics franceStats = new Statistics("France", 7845245, 14548, 7845512, 56, 488954, 11235, 785200, 7.85);
        Statistics brasilStats = new Statistics("Brazil", 1225445, 48481, 123358788, 8855, 54454, 111555, 87455265,
                9.85);
        Statistics croatiaStats = new Statistics("Croatia", 1445565225, 1454, 12345845, 10, 4847747, 454, 4545454,
                2.48);
        Statistics azoresStats = new Statistics("Azores", 157854, 1235, 201, 2, 10, 200, 14744, 1.48);

        Cache.cacheMap.put("country_france_statistics", franceStats);
        Cache.cacheMap.put("country_brazil_statistics", brasilStats);
        Cache.cacheMap.put("country_croatia_statistics", croatiaStats);

        expectedCashMap.put("country_france_statistics", franceStats);
        expectedCashMap.put("country_brazil_statistics", brasilStats);
        expectedCashMap.put("country_croatia_statistics", croatiaStats);

        // Assert that cache worked perfectly fine
        assertThat(Cache.cacheMap, is(expectedCashMap));

        // Assert cache size
        assertThat(Cache.cacheMap.size(), is(6));

        // Cache has the right inputs, doesn't contain any value that wasn't add
        assertThat(Cache.cacheMap, IsMapContaining.hasEntry("country_france_statistics", franceStats));
        assertThat(Cache.cacheMap, IsMapContaining.hasEntry("country_name_france_return_place", france));
        assertThat(Cache.cacheMap, not(IsMapContaining.hasEntry("country_name_france_return_place", azores)));
        assertThat(Cache.cacheMap, not(IsMapContaining.hasEntry("country_azores_statistics", azoresStats)));

        // Cache is able to save countries and its statistics

        assertThat(Cache.cacheMap, IsMapContaining.hasEntry("country_name_france_return_place", france));
        assertThat(Cache.cacheMap, IsMapContaining.hasEntry("country_france_statistics", franceStats));

        // Cache has the right keys (country and statistics) and its expected values
        assertThat(Cache.cacheMap, IsMapContaining.hasKey("country_name_croatia_return_place"));
        assertThat(Cache.cacheMap, IsMapContaining.hasKey("country_croatia_statistics"));
        assertThat(Cache.cacheMap, IsMapContaining.hasValue(croatia));
        assertThat(Cache.cacheMap, IsMapContaining.hasValue(croatiaStats));

        // Cache doesn't have the keys that weren't add
        assertThat(Cache.cacheMap, not(IsMapContaining.hasValue(azores)));
        assertThat(Cache.cacheMap, not(IsMapContaining.hasValue(azoresStats)));
        
        
        
        //After 10 seconds an object is removed from a cache
            
        ClockRemoveFromCache("country_name_croatia_return_place");
        TimeUnit.SECONDS.sleep(10); // Waiting 10 seconds for the object being removed. Altough it was only needed 1, + safety 
        assertThat(Cache.cacheMap, not(IsMapContaining.hasKey("country_name_croatia_return_place")));


        // Test if hits and miss are working correctly
        //its expected 2 hits and 2 misses
        Object obj = Cache.cacheMap.get("country_name_france_return_place"); //hit
        Object obj2 = Cache.cacheMap.get("country_name_azores_return_place"); //miss
        Object obj3 = Cache.cacheMap.get("country_name_brazil_return_place"); //hit
        Object obj4 = Cache.cacheMap.get("country_name_anotherplace_return_place"); //miss
        Object obj5 = Cache.cacheMap.get("country_name_croatia_return_place"); //miss, was just removed from cache


        Status st = new Status(0, 0);

        if (obj == null) {
            st.setMiss();
        } else{
            st.setHit();
        }
        if (obj2 == null) {
            st.setMiss();
        } else {
            st.setHit();
        }
        if (obj3 == null) {
            st.setMiss();
        } else {
            st.setHit();
        }
        if (obj4 == null) {
            st.setMiss();
        } else {
            st.setHit();
        }
        if (obj5 == null) {
            st.setMiss();
        } else {
            st.setHit();
        }
        
        
        assertThat(st.getHit(), is(2));
        assertThat(st.getMiss(), is(3));

    }

    public void ClockRemoveFromCache(String obj) {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Cache.cacheMap.remove(obj);
                    }
                },
                1000);
    }
}
