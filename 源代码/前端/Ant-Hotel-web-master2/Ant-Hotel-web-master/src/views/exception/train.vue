<template>
<div>

  <div  class="mb-10">
   <label>起始城市<input v-model="StartCity"/></label>

    <label>结束城市<input v-model="EndCity"/></label>

    <label>推荐值<input v-model="Recommend"/></label>

    <button @click="getData()">查询</button>
  </div>

  <div class="mb-10"  v-for="train in trains" v-bind:key="train">
    <ul>
      <li>出发站：{{train.departureStationName}}</li>
      <li>结束站：{{train.arriveStationName}}</li>
      <li>推荐值：{{train.recommad}}</li>
      <li>价钱：{{train.thePrice}}</li>
      <li>车辆：{{train.vehicleName}}</li>
      <li>出发时间：{{train.departureTime}}</li>
      <li>结束时间：{{train.arriveTime}}</li>
      <li><button @click="getTrainShow(
        train.departureStationNameLocationLng,
        train.departureStationNameLocationLat,
        train.arriveStationNameLocationLng,
        train.arriveStationNameLocationLat,
      )">展示</button></li>
    </ul>
  </div>

  <baidu-map class="map" ak="2ScuT42mtQVhOOMdUfwHlZQDUV2G7r68" :center="{lng: 116.404, lat: 39.915}" :zoom="7" :scroll-wheel-zoom="false" :massClear="true"> 
    <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-navigation>
    <bm-overview-map anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :isOpen="true"></bm-overview-map>
   <bm-polyline :path="polylinePath" stroke-color="blue" :stroke-opacity="0.5" :stroke-weight="2" :editing="true" @lineupdate="updatePolylinePath"></bm-polyline>
  </baidu-map>

</div>
</template>
    

<script>
import BaiduMap from 'vue-baidu-map/components/map/Map.vue'
import {BmlMarkerClusterer} from 'vue-baidu-map'
import {BmOverviewMap} from 'vue-baidu-map'
import {BmNavigation} from 'vue-baidu-map'
import {BmPointCollection} from  'vue-baidu-map'
import {BmPolyline} from  'vue-baidu-map'
import {BmControl} from  'vue-baidu-map'
import {getTrain} from '../../api/manage'
export default {
    components: {
      BaiduMap,
      BmlMarkerClusterer,
      BmOverviewMap,
      BmNavigation,
      BmPointCollection,
      BmPolyline,
      BmControl
  },
    data () {
        return {
            polylinePath: [],
            trains:[]
        }
    },
    methods: {

        getData(){
            getTrain({startCity:this.StartCity,endCity:this.EndCity,recommand:this.Recommend}).then(res=>{
                console.log(res.data)
                this.trains=res.data
            })
        },

         getTrainShow (departureStationNameLocationLng,departureStationNameLocationLat,arriveStationNameLocationLng,arriveStationNameLocationLat) {
             this.polylinePath = []
             this.polylinePath.push({lng: departureStationNameLocationLng, lat: departureStationNameLocationLat})
             this.polylinePath.push({lng: arriveStationNameLocationLng, lat: arriveStationNameLocationLat})
        },
    },
}
</script>



<style scoped>
  .map {
    width: 100%;
    height: 600px;
  }
  .mb-10 li{
      display: inline-block;
  }
</style>
