//
//  BPSingleLinkedList.m
//  bestpay
//
//  Created by roki on 2017/6/6.
//  Copyright © 2017年 Bestpay. All rights reserved.
//

#import "SingleLinkedList.h"

@interface SingleLinkedList()

@property (nonatomic,assign)NSInteger length;

@property (nonatomic,weak)id header;

@property (nonatomic,weak)id footer;

@end

@implementation SingleLinkedList



@end


@implementation Node

+ (instancetype)nodeWith:(id)data {
    
    Node *node = [[Node alloc] init];
    node.data = data;
    
    return node;
}


- (Node *)addElement:(Node *)element {
    
    if (self.next) {
        element.next = self.next;
        self.next = element;
    } else {

        self.next = element;
    }
    
    return element;
}

@end
