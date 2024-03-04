import React, { useState, useEffect } from 'react';

// useEffect : 시작 또는 변경사항 업데이트 대한 랜더링이 모두 끝난 시점에 발생
//             React가 DOM을 업데이트한 뒤 추가로 코드를 실행해야 하는 경우 사용됨
//             리액트에서 onReady와 같은 효과로 아주 빈번하게 사용 될 예정 ★★★★★
//             ajax의 시작점으로 빈번하게 활용 된다!

const Info1 = () => {
    const [name, setName] = useState('');
    const [nickName, setNickName] = useState('');

    useEffect(()=>{
        // 모두 렌더링이 되거나 변경이 감지되면 이벤트가 발생하는 구간!
        console.log('변경이 감지됨, name : ' + name + ', nickName : ' + nickName);
    });

    const onChangeName = (e)=>{
        setName(e.target.value);
    }
    
    const onChangeNickName = (e)=>{
        setNickName(e.target.value);
    }

    return (
        <div>
            <h3>Info1</h3>
            이름 : <input type="text" name="name" value={name} onChange={onChangeName}/><br/>            
            별칭 : <input type="text" name="nickName" value={nickName} onChange={onChangeNickName}/><br/> 
            <hr/>
            이름 : {name}<br/>
            별칭 : {nickName}<br/>
        </div>
    );
}

export default Info1;