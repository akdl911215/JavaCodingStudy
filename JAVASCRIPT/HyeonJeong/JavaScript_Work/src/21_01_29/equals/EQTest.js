const EQTest = () => {
    let name = "test"

    // value에 뭔가 있으면?
    if(name) {
        console.log("true")
    } else {
        console.log("false")
    }

    if(!name) {
        console.log("(not) true")
    } else {
        console.log("(not) false")
    }

    return (
        <div className = "EQTest">
            <p>
                Equals Test
            </p>
        </div>
    )
}

export default EQTest