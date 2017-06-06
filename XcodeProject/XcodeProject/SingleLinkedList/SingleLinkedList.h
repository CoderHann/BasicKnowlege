//
//  BPSingleLinkedList.h
//  bestpay
//
//  Created by roki on 2017/6/6.
//  Copyright © 2017年 Bestpay. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface SingleLinkedList<id> : NSObject

- (void)add:(id)objc;

@end



@interface Node<id> : NSObject

@property (nonatomic,strong)id data;

@property (nonatomic,strong)Node<id> *next;

+ (instancetype)nodeWith:(id)data;


- (Node *)addElement:(Node<id> *)element;


@end
