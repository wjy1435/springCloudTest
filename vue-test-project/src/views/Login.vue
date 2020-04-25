<template>
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名" prop="username">
            <el-input type="input" v-model="ruleForm.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
<!--            <el-button @click="resetForm('ruleForm')">重置</el-button>-->
        </el-form-item>
    </el-form>
</template>

<script>
    import * as api from '../url/url'
    // import * as axios from 'axios'
    export default {
        name: "login.vue",
        data() {
            var validatePass = (rule, value, callback) => {
                // alert(value);
                if (value === '') {
                    callback(new Error('请输入用户名'));
                } else {
                    if (this.ruleForm.username !== '') {
                        // this.$refs.ruleForm.validateField('username');
                    }
                    callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                }  else {
                    callback();
                }
            };
            return {
                ruleForm: {
                    username: '',
                    password: ''
                    // age: ''
                },
                rules: {
                    username: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    password: [
                        { validator: validatePass2, trigger: 'blur' }
                    ]

                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let info = {
                            name:this.ruleForm.username,
                            password:this.ruleForm.password
                        }
                        api.userLogin(info).then(res =>{
                            if(res){
                                console.log(res)
                                if(res.status == 200){

                                    let names = res.data.results
                                    this.$router.push({path:'/Homepage',query:{name:names}})
                                }else{
                                    alert("用户名或密码错误！！！"+{type:"error"});
                                }
                            }
                        }).catch(function (error) {
                            alert(error.toString()+{type:"error"}+"888");
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            // resetForm(ruleForm) {
            //     this.$refs[ruleForm].resetFields();
            // }
        }
    }
</script>

<style scoped>

</style>