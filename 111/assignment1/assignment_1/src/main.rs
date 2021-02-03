fn main() {
    let int0 = -9;
    let int1 = -7;
    let int2 = 7.7888;
    let int3 = -5;
    let int4 = 1.34;

    if int0 >= int1 && int0 >= int2 && int0 >= int3 && int0 >= int4 {
        println!("{}", int0);
    }else if int1 >= int0 && int1 >= int2 && int1 >= int3 && int1 >= int4 {
        println!("{}", int1);
    }else if int2 >= int0 && int2 >= int1 && int2 >= int3 && int2 >= int4 {
        println!("{}", int2);
    }else if int3 >= int0 && int3 >= int1 && int3 >= int2 && int3 >= int4 {
        println!("{}", int3);
    }else if int4 >= int0 && int4 >= int1 && int4 >= int2 && int4 >= int3 {
        println!("{}", int4);
    }
}
