import React, { Component } from 'react';

// https://ko.legacy.reactjs.org/docs/state-and-lifecycle.html

// state Class 구조 예제
// props : 컴포넌트가 선언(생성)되는 과정에서 부모 컴포넌트가 설정하는 값들, 
//         또는 외부(html)에서 받아오는 값들, 정적인 값
// state : 컴포넌트 내부에서 상태에 따라 변경되고 사용할수 있는 내부 변수, 
//         동적인 값으로 상태에 따라 변경될 수 있다.

// setState를 사용하는 패턴
class Counter extends Component {

    // 컴포넌트에서 바뀔 값을 선언하는 state
    state = {
        number : 0,
        fixedNumber : 0,
    };

    render(){
        const {number, fixedNumber} = this.state;
        const onClickHandler = ()=>{
            this.setState(
                // 첫번째 인자 : 업데이트 하고 싶은 내용
                {
                    number: number+1,
                    // fixedNumber : fixedNumber +2,
                },
                // 두번째 인자 : 옵션, callback 함수를 넣을 수 있다. -> 호출된 이후에 추가적인 작업이 필요할 때
                ()=>{
                    console.log('state 업데이트 되었습니다.')
                    console.log(this.state);
                    alert('update 완료!');
                }
            );
        }

        return (<div>
                    <h1>바뀔 값 : {number}</h1>
                    <h1>바뀌지 않을 값 : {fixedNumber}</h1>
                    <button onClick={onClickHandler}> +1 </button>
                </div>)
    }
}
export default Counter;
