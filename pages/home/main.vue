<template>
	<div class="container">
		<block v-for="(item,index) in data.list" :key="index">
			<image class="cover" :src="item.source" mode="widthFix" />
			<view class="cover-author">
				<text class="gray">{{item.source}}</text>
			</view>
			<view class="content">
				<text>{{item.title}}</text>
			</view>
			<view class="content-author">
				<text class="gray">{{item.source}}</text>
			</view>
			<weather :weather="weather" v-if="weather.status === 'ok'"></weather>
		</block>
	</div>
</template>

<script>
	import {
		mapState,
		mapActions
	} from 'vuex'
	import weather from './weather'
	export default {
		mounted() {
			this.initPage()
		},
		components: {
			weather
		},
		computed: {
			...mapState('home', ['data']),
			...mapState('weather', ['weather']),
			content () {
				// return this.data.hp_content.split('by')[0]
			}
		},
		methods: {
			...mapActions('home', ['getNewIds', 'getWxArtList', 'getTest']),
			async initPage() {
				await this.getWxArtList()
				console.log(this);
			}
		}
	}
</script>

<style scoped>
	.cover {
		width: 100%;
	}

	.cover-author {
		width: 100%;
		height: 100rpx;
		line-height: 100rpx;
		margin-bottom: 30rpx;
	}

	.content {
		width: 80%;
		margin: 0 auto;
		line-height: 58rpx;
		text-align: left;
	}

	.content-author {
		height: 100rpx;
		line-height: 100rpx;
		font-size: 20rpx;
	}
</style>
