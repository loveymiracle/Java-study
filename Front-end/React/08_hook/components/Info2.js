import React from 'react';
import useInputs from './useInputs';


// 커스텀 Hook 사용 예제
const Info2 = () => {
  const [state, onChange] = useInputs({
    name: '',
    nickname: ''
  });
  const { name, nickname } = state;

  return (
    <div>
      <h3>Info2</h3>
      <div>
        <input name="name" value={name} onChange={onChange} />
        <input name="nickname" value={nickname} onChange={onChange} />
      </div>
      <div>
        <div>
          <b>이름:</b> {name}
        </div>
        <div>
          <b>닉네임: </b> {nickname}
        </div>
      </div>
    </div>
  );
};

export default Info2;
