<template>
<!--    vue模板只能有一个根对象-->
    <div>
    <el-table  :data="tableData">
        <el-table-column prop="id" label="id" width="140">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="120">
        </el-table-column>
        <el-table-column prop="password" label="密码">
        </el-table-column>
    </el-table>
    <el-pagination
            @current-change="getUserList"
            :page-size="pageSize"
            :current-page="currentPage"
            background
            layout="total, sizes, prev, pager, next, jumper"
            :total="totalNum"
            :model = "1">
    </el-pagination>
    </div>
<!--    :data="tableData"-->
<!--    <span> {{ddd}}</span>-->
</template>
<script>
    // import __ from '__' // __是需要手动引入的文件
    import * as api from '../url/url'
    export default {
        // props:["tableData"],
        name: '',
        components: {},
        data() {
            return {
                // msg: '这个是Home模板页',
                //  tableData:this.$router.query.tableData
                currentPage: 1,//默认显示第一页
                pageSize:10,//默认每页显示10条
                totalNum: 1, //总页数
                tableData :[]
            }
        },
        methods: {
            // created:function(){
            //    this.getUserLis1t('1')
            // },
            getUserLis1t(val) {
                let  info = {
                    page:val,
                    size:this.pageSize
                }
                // alert(info)
                api.userPages(info).then(res =>{
                    if(res){
                        console.log(res)
                        if(res.status == 200){
                            this.tableData = res.data.rows
                            this.totalNum = res.data.total
                            // this.pageSize = res.data.size
                            // this.currentPage = res.data.page
                        }else{
                            alert("w无数据！！！"+{type:"error"});
                        }
                    }
                }).catch(function (error) {
                    alert(error.toString()+{type:"error"}+"888");
                })
            }
        }
    }
</script>
<style lang="postcss" scoped>
    body {
        background-color: #ff0000;
    }
</style>
