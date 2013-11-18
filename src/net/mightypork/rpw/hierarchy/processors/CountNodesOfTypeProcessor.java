package net.mightypork.rpw.hierarchy.processors;


import java.util.HashSet;
import java.util.Set;

import net.mightypork.rpw.hierarchy.EAsset;
import net.mightypork.rpw.hierarchy.tree.AssetTreeGroup;
import net.mightypork.rpw.hierarchy.tree.AssetTreeLeaf;
import net.mightypork.rpw.hierarchy.tree.AssetTreeNode;
import net.mightypork.rpw.hierarchy.tree.AssetTreeProcessor;


public class CountNodesOfTypeProcessor implements AssetTreeProcessor {

	private EAsset type;

	private int count = 0;

	private Set<AssetTreeNode> processed = new HashSet<AssetTreeNode>();


	public CountNodesOfTypeProcessor(EAsset type) {

		this.type = type;
	}


	@Override
	public void process(AssetTreeNode node) {

		if (processed.contains(node)) return; // no double-processing
		processed.add(node);

		if (node instanceof AssetTreeGroup) {

			return; // we want leafs

		} else if (node instanceof AssetTreeLeaf) {

			AssetTreeLeaf leaf = (AssetTreeLeaf) node;

			if (leaf.getAssetType() == type) count++;
		}
	}


	public int getCount() {

		return count;
	}

}