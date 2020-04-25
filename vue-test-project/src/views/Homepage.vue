<template>
    <el-container style="height: 500px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu :default-openeds="['1', '3']">
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-message"></i>导航一</template>
                    <el-menu-item-group>
                        <template slot="title">分组一</template>
                        <el-menu-item index="1-1" @click ="omName='Table';getChildrenMethod('1');">选项1</el-menu-item>
                        <el-menu-item index="1-2" @click ="comName='AddData'">选项2</el-menu-item>

                    </el-menu-item-group>
                    <el-menu-item-group title="分组2">
                        <el-menu-item index="1-3">选项3</el-menu-item>
                    </el-menu-item-group>
                    <el-submenu index="1-4">
                        <template slot="title">选项4</template>
                        <el-menu-item index="1-4-1">选项4-1</el-menu-item>
                    </el-submenu>
                </el-submenu>
            </el-menu>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>查看</el-dropdown-item>
                        <el-dropdown-item>新增</el-dropdown-item>
                        <el-dropdown-item>删除</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span>{{this.$route.query.name}}</span>
            </el-header>

            <el-main >
<!--                <keep-alive>-->
                    <Table   ref="child1" :is="comName"></Table>
<!--                </keep-alive>-->

<!--                    </router-link>-->
<!--                :tableData="tableData"-->
<!--                v-show="dialog_visible"-->
<!--                <keep-alive>-->
                    <AddData  :is="comName"></AddData>
<!--                </keep-alive>-->

            </el-main>
            <div class="block">
<!--                <el-pagination-->
<!--                        @current-change="getUserList"-->
<!--                        :page-size="pageSize"-->
<!--                        :current-page="currentPage"-->
<!--                        background-->
<!--                        layout="total, sizes, prev, pager, next, jumper"-->
<!--                        :total="totalNum"-->
<!--                        :model = "1">-->
<!--                </el-pagination>-->
            </div>
        </el-container>
    </el-container>

</template>

<script>
    // import * as api from '../url/url'
    import  Table from '../views/Table'
    import AddData from "./AddPage";
    // import AddPage from '../views/AddPage'
    export default {
        // mounted:function(){
        //     this.currentPage = 1,
        //     this.pageSize = 5
        // },
        methods:{
            getChildrenMethod(val){
                // this.comName = Table;
                this.$nextTick(() => {
                    this.$refs.child1.getUserLis1t(val);
                })

                // this.dialog_visible = true;
            },
            // getAddPage(){
            //     this.dialog_visible1 = true;
            //     this.dialog_visible = false;
            //     alert(2);
            // }
            // change(temp){
            //     this.com_name = temp;
            // }
            // getUserList(val) {
            //     let  info = {
            //         page:val,
            //         size:this.pageSize
            //     }
            //     // alert(info)
            //     api.userPages(info).then(res =>{
            //         if(res){
            //             console.log(res)
            //             if(res.status == 200){
            //                 this.dialog_visible = true;
            //                 this.tableData = res.data.rows
            //                 this.totalNum = res.data.total
            //                 // this.pageSize = res.data.size
            //                 // this.currentPage = res.data.page
            //             }else{
            //                 alert("w无数据！！！"+{type:"error"});
            //             }
            //         }
            //     }).catch(function (error) {
            //         alert(error.toString()+{type:"error"}+"888");
            //     })
            // }
        },

        data() {
            return {
                // tableData: [],
                // currentPage: 1,//默认显示第一页
                // pageSize:10,//默认每页显示10条
                // totalNum: 1, //总页数
                name: this.$route.query.name,
                // dialog_visible :false,
                // dialog_visible1:false,
                // activeName: "first",
                // com_name:''
                comName: ""
            };
        },
        components:{
            AddData,                         //再注册
            Table,

        },
    };
</script>

<style scoped>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
</style>