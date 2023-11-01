console.log(bnoVal + "/");

async function postCommentToServer(cmtData) {
    try {

        const url = "/comment/post"
        const config = {
            method: "post",
            headers: {
                'content-type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(cmtData)
        };

        const resp = await fetch(url, config);
        const result = await resp.text(); //isok

        return result;

    } catch (err) {
        console.log(err);
    }

}
document.getElementById('cmtPostBtn').addEventListener('click', () => {

    const cmtText = document.getElementById('cmtText').value;
    const cmtWriter = document.getElementById('cmtWriter').innerText;
    if (cmtText == "" || cmtText == null) {
        alert("댓글을 입력하세요");
        document.getElementById('cmtText').focus();
        return false;
    } else {
        let cmtData = {
            bno: bnoVal,
			writer : cmtWriter,
            content: cmtText
        };
        console.log(cmtData);
        postCommentToServer(cmtData).then(result => {
            console.log(result);

            //isok 확인
            if (result == "1") {
                alert("댓글등록 성공");
                // 화면에 뿌리기
                getCommentList(bnoVal);
            }
        })
    }

})




async function spreadCommentListFromServer(bno) {
    try {
        const resp = await fetch('/comment/' + bno);
        const result = await resp.json();
        return result;

    } catch (err) {
        console.log(err);
    }
}



function getCommentList(bno) {
    spreadCommentListFromServer(bno).then(result => {
        console.log(result);
        const ul = document.getElementById('cmtlistArea');
        if (result.length > 0) {
            ul.innerHTML = "";
            for (let cvo of result) {
                let li = `<li data-cno="${cvo.cno}" data-writer="${cvo.writer}"><div>`;
                li += `${cvo.writer}<br>`;
                li += `<input type="text" id="cmtTextMod" value="${cvo.content}"></div>`;
                li += `<span>${cvo.reg_date}</span>`;

                if (cvo.writer == cnowriter) {
                    li += `<button type="button" class="modBtn">%</button>`;
                    li += `<button type="button" class="delBtn">X</button>`;
                }


                li += `</li>`; //li는 빼줘야 한다
                ul.innerHTML += li;
            }
        } else {
            let li = `<li>CommentList Empty</li>`;
            ul.innerHTML = li;
        }
    });
}


async function editCommentToServer(cmtModData) {
    try {
        const url = '/comment/' + cmtModData.cno;
        console.log(url);
        const config = {
            method: 'put',
            headers: {
                'content-type': 'application/json; charset=utf-8'
            },

            body: JSON.stringify(cmtModData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}




async function removeCommentToServer(cmtDelDate) {
    try {
        const url = '/comment/' + cmtDelDate.cno;
        const config = {
            method: 'delete',

            headers: {
                'content-type': 'application/json; charset=utf-8'
            },

            body: JSON.stringify(cmtDelDate)
        };
        console.log(url);
        console.log("제발");
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;

    } catch (error) {
        console.log(error);
    }
}

document.addEventListener('click', (e) => {




    console.log(e.target);
    if (e.target.classList.contains('modBtn')) {
        //수정작업
        console.log("수정버튼 클릭");
        //내가 선택한 타겟과 가장 가까운 li 찾기
        let li = e.target.closest('li');
        let conVal = li.dataset.cno;
        let textContent = li.querySelector('#cmtTextMod').value;
        console.log("cno/content: " + conVal + " / " + textContent);

        let cmtModData = {
            cno: conVal,
            content: textContent
        };
        console.log(cmtModData);
        //서버 연결
        editCommentToServer(cmtModData).then(result => {
            if (result == 1) {
                alert("댓글 수정 성공");
            }
            getCommentList(bnoVal);
        })

    }
    else if (e.target.classList.contains('delBtn')) {
        //삭제작업
        console.log("삭제버튼 클릭");
        let li = e.target.closest('li')
        let cnoVal = li.dataset.cno;
        let cmtDelDate = {
            cno: cnoVal
        };
        console.log("ㅋㅋ" + cmtDelDate);

        removeCommentToServer(cmtDelDate).then(result => {
            if (result > 0) {
                console.log(cmtDelDate);
                alert('댓글 삭제 성공');
                getCommentList(bnoVal);
            } else {
                alert("댓글 삭제 실패");
            }
        })
    }


})