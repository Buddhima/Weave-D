/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.ikasl.core.aggregate;

import com.weaved.ikasl.objects.GNode;
import com.weaved.ikasl.objects.Node;
import java.util.List;

/**
 *
 * @author Thush
 */
public interface IKASLGeneralizer {
    public GNode generalize(Node hit, List<Node> neigh1, List<Node> neigh2, double disthreshold, int dims);
}
