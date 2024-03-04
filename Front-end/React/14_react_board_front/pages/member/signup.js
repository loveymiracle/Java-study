'use client';


import { Inter } from 'next/font/google'
import * as React from 'react';
import { useState, useEffect } from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import axios from 'axios';
import '../globals.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from '../../components/header';
import Footer from '../../components/footer';



const inter = Inter({ subsets: ['latin'] })
const defaultTheme = createTheme();

export default function Signup() {

    useEffect(() => {
        logout();
    });

    const handleSubmit = (event) => {
        event.preventDefault();
        const form = new FormData(event.currentTarget);
        signupRequest(form);
    };

    const onClickCheckDuplicate = (event) => {
        checkDuplicate(memberId);
    };


    const [memberId, setMemberId] = useState();
    const onChangeMemberId = (event) =>{
        setMemberId(event.target.value)
    }

    const checkDuplicate  = async (memberId) => {
        try {
            console.log(memberId);
            const response = await axios.get('http://localhost/memberRest/idCheck?memberId='+memberId, { withCredentials: true });
            console.log(response);
            if (response.data.validate === false) {
                alert(memberId +'는 사용 가능합니다.');
            } else {
                alert('중복된 아이디 입니다.');
            }
        } catch (e) {
            console.log(e);
        }
    }


    const signupRequest = async (form) => {
        try {
            let axiosConfig = {
                withCredentials: true,
                headers: {
                    "Content-Type": "multipart/form-data",
                }
            }
            const response = await axios.post('http://localhost/memberRest/enroll', 
                                                          form, axiosConfig);
            if(response == null){
                alert('회원가입 실패');
            }
            if (response.data.result === true) {
                alert('회원가입 성공');
                location.href = "/";
            } else {
                alert('회원가입 실패');
                location.href = "/";
            }
        } catch (e) {
            alert('회원가입 실패');
            console.log(e);
        }
    }

    const logout = async () => {
        try {
            const response = await axios.get('http://localhost/memberRest/logout', { withCredentials: true });
            console.log(response)
        } catch (e) {
            console.log(e);
        }
    }

    return (
        <>
            <Header />
            <section id="content">
                <br />
                <h3 align="center">회원가입 정보</h3>
                <form id="enroll-container" name="memberEnrollFrm" onSubmit={handleSubmit} >
                    <table>
                        <tbody>
                            <tr>
                                <th>아이디</th>
                                <td>
                                    <input type="text" onChange={onChangeMemberId} name="memberId" id="newId" placeholder="아이디 (4글자 이상)" required />
                                    <input type="button" id="checkDuplicate" onClick={onClickCheckDuplicate} value="중복검사" />
                                </td>
                            </tr>
                            <tr>
                                <th>패스워드</th>
                                <td>
                                    <input type="password" name="password" id="pass1" required />
                                </td>
                            </tr>
                            <tr>
                                <th>패스워드 확인</th>
                                <td>
                                    <input type="password" id="pass2" required />
                                </td>
                            </tr>
                            <tr>
                                <th>이름</th>
                                <td>
                                    <input type="text" name="name" required />
                                </td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                                <td>
                                    <input type="tel" name="phone" maxLength={11}  placeholder="(-없이)01012345678" />
                                </td>
                            </tr>
                            <tr>
                                <th>이메일</th>
                                <td>
                                    <input type="email" name="email" />
                                </td>
                            </tr>
                            <tr>
                                <th>주소</th>
                                <td>
                                    <input type="text" name="address" />
                                </td>
                            </tr>
                            <tr>
                                <th>취미</th>
                                <td>
                                    <label><input type="checkbox" name="hobby" value="운동" />운동</label>
                                    <label><input type="checkbox" name="hobby" value="등산" />등산</label>
                                    <label><input type="checkbox" name="hobby" value="독서" />독서</label>
                                    <label><input type="checkbox" name="hobby" value="게임" />게임</label>
                                    <label><input type="checkbox" name="hobby" value="여행" />여행</label>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="submit" id="enrollSubmit" value="가입" />
                    <input type="reset" value="취소" />
                </form>
            </section>
            <Footer />
        </>
    );
}